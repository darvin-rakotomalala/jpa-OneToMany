package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Post;
import com.poc.model.dto.PostDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PostMapper extends DtoMapper<PostDTO, Post> {

}
