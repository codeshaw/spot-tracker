package com.codeshaw.tracker.mapping;

import com.codeshaw.tracker.domain.CheckIn;
import com.codeshaw.tracker.dto.spot.Response;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper extends ConfigurableMapper {

  @Override
  protected void configure(MapperFactory factory) {
    factory.classMap(CheckIn.class, Response.class);
  }
}
