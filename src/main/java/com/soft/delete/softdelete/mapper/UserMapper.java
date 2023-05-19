package com.soft.delete.softdelete.mapper;

import com.soft.delete.softdelete.dto.UserDto;
import com.soft.delete.softdelete.entity.UserDbo;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "deleted", ignore = true)
  @Mapping(target = "deletedAt", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  UserDbo toDbo(UserDto user);

  UserDto toDto(UserDbo user);

  List<UserDbo> toDbo(List<UserDto> user);

  List<UserDto> toDto(List<UserDbo> user);
}
