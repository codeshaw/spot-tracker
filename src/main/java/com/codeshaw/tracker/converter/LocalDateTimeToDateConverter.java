package com.codeshaw.tracker.converter;

import org.joda.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeToDateConverter implements AttributeConverter<LocalDateTime, Date>{

  @Override
  public Date convertToDatabaseColumn(LocalDateTime attribute) {
    return null;
  }

  @Override
  public LocalDateTime convertToEntityAttribute(Date dbData) {
    return null;
  }
}
