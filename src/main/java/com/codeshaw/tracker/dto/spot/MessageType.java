package com.codeshaw.tracker.dto.spot;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum MessageType {
  OK,
  TRACK,
  CUSTOM,
  HELP,
  HELP_CANCEL;
}
