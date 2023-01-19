package com.poc.mapper;

import com.poc.model.domain.Comment;
import com.poc.model.dto.CommentDTO;
import com.poc.utils.HelpPage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostMapper.class})
public interface CommentMapper {

    Comment toDO(CommentDTO dto);

    @Mapping(target = "idPost", source = "post.id")
    CommentDTO toDTO(Comment entity);

    List<Comment> toDO(List<CommentDTO> dtoList);

    List<CommentDTO> toDTO(List<Comment> entityList);

    default HelpPage<CommentDTO> toDTO(Page<Comment> entityPage, Pageable pageable) {
        List<CommentDTO> dtoList = toDTO(entityPage.getContent());
        return new HelpPage<>(dtoList, pageable, entityPage.getTotalElements());
    }

}
