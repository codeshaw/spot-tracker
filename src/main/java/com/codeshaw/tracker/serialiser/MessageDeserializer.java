package com.codeshaw.tracker.serialiser;

import com.codeshaw.tracker.dto.spot.Message;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom {@link JsonDeserializer} for the Spot {@link Message}.
 *
 * <p>
 *   This is necessary as the SPOT API returns incorrect (badly formatted) JSON when there is a single check-in element.
 *   Instead of an array in "messages:", it's a single value underneath, which means there's an exception with a single
 *   element.
 * </p>
 */
public class MessageDeserializer extends JsonDeserializer<List<Message>> {

  @Override
  public List<Message> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    List<Message> messages = new ArrayList<>();

    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);

    if (node.isArray()) {
      for (final JsonNode objNode : node) {
        messages.add(parseMessageFromNode(deserializationContext, objNode));
      }
    } else {
      messages.add(parseMessageFromNode(deserializationContext, node));
    }

    return messages;
  }

  private Message parseMessageFromNode(DeserializationContext deserializationContext, JsonNode jsonNode) throws IOException{
    JavaType jacksonType = deserializationContext.getTypeFactory().constructType(Message.class);
    JsonDeserializer<?> deserializer = deserializationContext.findRootValueDeserializer(jacksonType);
    JsonParser nodeParser = jsonNode.traverse(deserializationContext.getParser().getCodec());
    nodeParser.nextToken();
    return (Message) deserializer.deserialize(nodeParser, deserializationContext);
  }
}
