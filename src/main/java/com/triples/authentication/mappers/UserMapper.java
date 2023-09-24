/* Copyright 2023 */
package com.triples.authentication.mappers;

import co.reldyn.cdxcommonutil.base.BaseMapper;
import com.triples.authentication.dto.UserDto;
import com.triples.authentication.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {}
