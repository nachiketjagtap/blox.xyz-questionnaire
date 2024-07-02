
package com.nachiket.Blox_Q_3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class JsonParser {

    public static Object parseJson(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        return convertJsonNode(jsonNode);
    }

    private static Object convertJsonNode(JsonNode jsonNode) {
        if (jsonNode.isObject()) {
            return convertJsonObject(jsonNode);
        } else if (jsonNode.isArray()) {
            return convertJsonArray(jsonNode);
        } else if (jsonNode.isBigInteger()) {
            return new BigInteger(jsonNode.asText());
        } else if (jsonNode.isBigDecimal()) {
            return new BigDecimal(jsonNode.asText());
        } else if (jsonNode.isTextual()) {
            return jsonNode.asText();
        } else if (jsonNode.isInt()) {
            return jsonNode.asInt();
        } else if (jsonNode.isLong()) {
            return jsonNode.asLong();
        } else if (jsonNode.isDouble()) {
            return jsonNode.asDouble();
        } else if (jsonNode.isBoolean()) {
            return jsonNode.asBoolean();
        } else if (jsonNode.isNull()) {
            return null;
        } else {
            throw new IllegalArgumentException("Unknown JSON node type");
        }
    }

    private static Map<String, Object> convertJsonObject(JsonNode jsonNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(jsonNode, Map.class);
    }

    private static List<Object> convertJsonArray(JsonNode jsonNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(jsonNode, List.class);
    }

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Nachiket\",\"age\":22,\"balance\":1000.55,\"isMember\":true,\"numbers\":[1, 2, 3],\"bigInt\":\"123456789012345678901234567890\"}";

        try {
            Object parsedObject = parseJson(jsonString);
            System.out.println(parsedObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
