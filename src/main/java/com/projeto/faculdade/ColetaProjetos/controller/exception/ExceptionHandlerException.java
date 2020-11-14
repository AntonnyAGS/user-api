package com.projeto.faculdade.ColetaProjetos.controller.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projeto.faculdade.ColetaProjetos.controller.exception.enumerator.ResponseHandlerExceptionEnum;
import com.projeto.faculdade.ColetaProjetos.controller.exception.model.response.CampoMensagemErroModelResponse;
import com.projeto.faculdade.ColetaProjetos.controller.exception.model.response.MensagemErroModelResponse;

/**
 * Classe responsável por realizar o tratamento
 * das exception que a api lança
 *
 * @author João Vitor
 * @since 24/10/2020
 */
@RestController
public class ExceptionHandlerException extends ResponseEntityExceptionHandler implements MessageSourceAware {

    private static final String FALHA = "Falha: ";
    private static final String TIPO_EXCEPTION = "Tipo execption: ";
    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException argumentNotValidException,
                                                                        HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {

        return handlerFieldErrors(argumentNotValidException.getBindingResult());
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException bindException,
                                                         HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {

        return handlerFieldErrors(bindException.getBindingResult());
    }

    /**
     * Método responsável por tratar excecoes genéricas, informando erroInternoNoServidor
     *
     * @param excecao {@code Exception}
     * 		- excecao a ser tratada
     * @param webRequest {@code WebRequest}
     * 		- requisicao web
     *
     * @return {@code ResponseEntity<Object>}
     * 		- payload de retorno com o código HTTP 500
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception excecao, WebRequest webRequest) {

        return this.handleErroInternoException(excecao);
    }

    /**
     * Método responsável por tratar excecoes de recursos inválidos, informando 'bad_request'
     *
     * @param excecao {@code Exception}
     * 		- excecao a ser tratada
     * @param webRequest {@code WebRequest}
     * 		- requisicao web
     *
     * @return {@code ResponseEntity<Object>}
     * 		- payload de retorno com o código HTTP 400
     */
    @ExceptionHandler(ParametroInvalidoException.class)
    public final ResponseEntity<Object> handleBadRequestExceptions(Exception excecao, WebRequest webRequest) {

        return this.handleBadRequestException(excecao);
    }

    /**
     * Método responsável por interceptar e tratar os erros 400 na aplicação.
     *
     * @param excecao {@code Exception}
     * 		- excecao lançada na aplicacao
     *
     * @return {@code ResponseEntity<Object>}
     * 		- entidade com o mapeamento de código e erro para statusCode 400
     */
    private ResponseEntity<Object> handleBadRequestException(Exception excecao) {

        this.logException(excecao);

        MensagemErroModelResponse mensagemErroModelResponse = new MensagemErroModelResponse();
        mensagemErroModelResponse.setCodigo(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        mensagemErroModelResponse.setMensagem(ResponseHandlerExceptionEnum.RECURSO_INVALIDO.getTextoException());

        return new ResponseEntity<>(mensagemErroModelResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Método responsável por interceptar e tratar os erros 500 na aplicação.
     *
     * @param excecao {@code Exception}
     * 		- excecao lançada na aplicacao
     *
     * @return {@code ResponseEntity<Object>}
     * 		- entidade com o mapeamento de código e erro para statusCode 500
     */
    private ResponseEntity<Object> handleErroInternoException(Exception excecao) {

        this.logException(excecao);

        MensagemErroModelResponse mensagemErroModelResponse = new MensagemErroModelResponse();
        mensagemErroModelResponse.setCodigo(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        mensagemErroModelResponse.setMensagem(ResponseHandlerExceptionEnum.ERRO_INESPERADO.getTextoException());

        return new ResponseEntity<>(mensagemErroModelResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Método responsável por interceptar e tratar os erros de 422 na aplicação
     *
     * @param excecao {@code Exception}
     * 		- excecao lançada na aplicacao
     *
     * @return {@code ResponseEntity<Object>}
     * 		- entidade com o mapeamento de código e erro para statusCode 422
     */
    private ResponseEntity<Object> handleUnprocessableEntity(Exception excecao) {

        this.logException(excecao);

        MensagemErroModelResponse mensagemErroModelResponse = new MensagemErroModelResponse();
        mensagemErroModelResponse.setCodigo(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()));
        mensagemErroModelResponse.setMensagem(ResponseHandlerExceptionEnum.RECURSO_NAO_AUTORIZADO.getTextoException());

        return new ResponseEntity<>(mensagemErroModelResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }


    /**
     * Método responsável por conter a lógica de tratamento de erros por problema de
     * binding na aplicação.
     *
     * @param bindingResult {@code BindingResult}
     * 		- resultados do binding realizado pela aplicação
     *
     * @return {@code ResponseEntity<Object>}
     * 		- response entity com a mensagem de erro no body e status {@code HttpStatus.BAD_REQUEST}
     */
    public  ResponseEntity<Object> handlerFieldErrors(BindingResult bindingResult) {

        List<CampoMensagemErroModelResponse> campos = new ArrayList<>();

        String nomeCampo;
        String valorParametro;
        String mensagem;

        for(FieldError fieldError : bindingResult.getFieldErrors()) {
            nomeCampo = montarSnakeCase(fieldError.getField());
            valorParametro = nullSafeToString(fieldError.getRejectedValue());
            mensagem = obterMensagem(fieldError);

            CampoMensagemErroModelResponse campoMensagem = new CampoMensagemErroModelResponse();
            campoMensagem.setCampo(nomeCampo);
            campoMensagem.setMensagem(mensagem);
            campoMensagem.setValor(valorParametro);

            campos.add(campoMensagem);
        }

        MensagemErroModelResponse mensagemErroModelResponse = new MensagemErroModelResponse();
        mensagemErroModelResponse.setCampo(ResponseHandlerExceptionEnum.VALIDATION_ERROR.getTextoException());
        mensagemErroModelResponse.setMensagem(ResponseHandlerExceptionEnum.ERRO_NA_VALIDACAO_DE_CAMPOS.getTextoException());
        mensagemErroModelResponse.setCampos(campos);

        return new ResponseEntity<>(mensagemErroModelResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Trata o nome do campo para estar em conformidade com o nome do parametro
     * que é informado na aplicação.
     *
     * @param nomeCampo {@code String} - Nome do campo a ser tratado em camelCase.
     *
     * @return {@code String} - Nome do campo tratado em snakeCase.
     */
    private String montarSnakeCase(String nomeCampo) {

        String valor = "([a-z]|([A-Z]+))";
        String replace = "$1_$2";

        return nomeCampo.replaceAll(valor, replace).toLowerCase();
    }

    /**
     * Converte o objeto indicado para {@code String}
     *
     * @param valorObjeto {@code Object} - Objeto a ser convertido
     *
     * @return	{@code String} - Caso o objeto indicado não seja nulo, retorna o objeto {@code String}
     * 			- Caso contrário, retorn <b>null</b>
     */
    private String nullSafeToString(Object valorObjeto) {

        if(Objects.isNull(valorObjeto)) {
            return null;
        }

        return valorObjeto.toString();
    }

    /**
     * Realiza o tratamento das mensagens de erro do campo indicado.
     *
     * @param campoErro {@code FieldError} - Campo com erro de binding
     *
     * @return {@code String} - Mensagem do erro do binding
     */
    private String obterMensagem(FieldError campoErro) {

        String saidaResultado = null;

        if(campoErro.getArguments().length == 1 && campoErro.getArguments()[0] instanceof MessageSourceResolvable) {
            MessageSourceResolvable mensagem = (MessageSourceResolvable) campoErro.getArguments()[0];
            saidaResultado = this.messageSource.getMessage(mensagem, Locale.getDefault());
        }

        if(StringUtils.isEmpty(saidaResultado) || campoErro.getField().equals(saidaResultado)) {
            saidaResultado = campoErro.getDefaultMessage();
        }

        return saidaResultado;
    }

    /**
     * Método responsável por logar o tipo e a classe da falha da excecao
     *
     * @param excecao {@code Exception}
     * 		- excecao causa do problema
     */
    private void logException(Exception excecao) {

        logger.error(FALHA + excecao.getMessage());
        logger.error(TIPO_EXCEPTION + excecao.getClass());
    }
}
