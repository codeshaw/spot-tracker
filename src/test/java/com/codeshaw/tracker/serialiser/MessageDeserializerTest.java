package com.codeshaw.tracker.serialiser;

import com.codeshaw.tracker.dto.spot.SpotResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Unit test class to test the functioning of {@link MessageDeserializer}, which is invoked transitively
 * via the {@link ObjectMapper}
 */
public class MessageDeserializerTest {

  private ObjectMapper objectMapper;

  @BeforeEach
  public void setup() {
    objectMapper = new ObjectMapper();
  }

  @Test
  public void testSingleObjectMapping() throws IOException{
    File singleResponseFile = new ClassPathResource("single-response.json").getFile();
    SpotResponse spotResponse = objectMapper.readValue(singleResponseFile, SpotResponse.class);
    assertThat(spotResponse.getResponse().getFeedMessageResponse().getMessages().getMessage().size(), is(1));
  }

  @Test
  public void testMultiObjectMapping() throws IOException{
    File multiResponseFile = new ClassPathResource("multi-response.json").getFile();
    SpotResponse spotResponse = objectMapper.readValue(multiResponseFile, SpotResponse.class);
    assertThat(spotResponse.getResponse().getFeedMessageResponse().getMessages().getMessage().size(), is(2));
  }

}