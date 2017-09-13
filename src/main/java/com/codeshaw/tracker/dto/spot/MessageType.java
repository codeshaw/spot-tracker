package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum MessageType {
  OK,
  TRACK,
  @JsonProperty("UNLIMITED-TRACK") UNLIMITED_TRACK,
  CUSTOM,
  HELP,
  HELP_CANCEL;
}
