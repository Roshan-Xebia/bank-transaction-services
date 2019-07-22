package com.bank.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.util.URISupport;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.data.MediaType;

import com.bank.model.Transactions;

/**
 * 1. Retrieve the inputs from exchange
 * 2. Marshalling and Unmarshalling json and pojo
 * 3. Building the response to exchange
 * @author Roshan
 *
 */
public final class ExchangeUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String getQueryParameter(Exchange exchange, String parameterName, String defaultValue)
			throws URISyntaxException {
		Map<String, Object> queryParameters = getQueryParameters(exchange);

		String parameterValue = (String) queryParameters.get(parameterName);
		if (parameterValue == null || parameterValue.isEmpty()) {
			return defaultValue;
		}
		return parameterValue;
	}

	private static Map<String, Object> getQueryParameters(Exchange exchange) throws URISyntaxException {
		return URISupport.parseQuery((String) exchange.getIn().getHeader("CamelHttpQuery", String.class));
	}
	
	/**
     * @param exchange     Exchange object
     * @param response     Custom response object to be returned
     * @param responseCode Response Code to be returned
     */
	public static  void createResponse(Exchange exchange, Object response, int responseCode)
            throws Exception
    {
        exchange.getOut().setHeader("CamelHttpResponseCode", Integer.valueOf(responseCode));
        if (response != null)
        {
            exchange.getOut().setHeader("Content-Type", MediaType.APPLICATION_JSON);
            exchange.getOut().setBody(convertToJson(response));
        }
    }
	
    /**
     * @param object Object to be converted to JSON
     * @return String Converted JSON string
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     * @throws BaseControllerException
     */
    public static String convertToJson(Object object) throws JsonGenerationException, JsonMappingException, IOException 
    {
        String result = null;
        if (object == null){
            return null;
        }
        result = objectMapper.writeValueAsString(object);
        return result;
    }

    /**
     * @param json          JSON to be converted to POJO
     * @param typeReference Type of Object to which JSON to be converted
     * @param <T>
     * @return <T> Converted Customer object
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     * @throws BaseControllerException
     */
    public static Transactions convertToPojo(String json) throws JsonGenerationException, JsonMappingException, IOException 
    {
        if (json == null){
            return null;
        }
        Object result = objectMapper.readValue(json, Transactions.class);
        return (Transactions) result;
    }
}
