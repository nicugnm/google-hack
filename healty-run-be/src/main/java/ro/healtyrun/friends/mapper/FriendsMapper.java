package ro.healtyrun.friends.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ro.healtyrun.friends.model.Friends;
import ro.healtyrun.friends.model.dto.FriendsDto;

import java.util.List;

@Mapper
public interface FriendsMapper {

    FriendsMapper INSTANCE = Mappers.getMapper(FriendsMapper.class);

    FriendsDto toDto(Friends friends);

    List<FriendsDto> toDtoList(List<Friends> friendsList);
}
