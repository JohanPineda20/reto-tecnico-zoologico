package com.nelumbo.zoo.mappers.entity;

import com.nelumbo.zoo.model.AnimalModel;
import com.nelumbo.zoo.model.AreaModel;
import com.nelumbo.zoo.model.CommentModel;
import com.nelumbo.zoo.model.SpecieModel;
import com.nelumbo.zoo.persistence.entity.AnimalEntity;
import com.nelumbo.zoo.persistence.entity.AreaEntity;
import com.nelumbo.zoo.persistence.entity.CommentEntity;
import com.nelumbo.zoo.persistence.entity.SpecieEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AreaEntityMapper {
    @Mapping(target = "species", qualifiedByName = "specieWithoutArea")
    AreaModel toAreaModel(AreaEntity areaEntity);
    AreaEntity toAreaEntity(AreaModel areaModel);

    @Named("specieWithoutArea")
    @Mapping(target = "area", ignore = true)
    @Mapping(target = "animals", qualifiedByName = "animalWithoutSpecie")
    SpecieModel toSpecieModel(SpecieEntity specieEntity);

    @Named("animalWithoutSpecie")
    @Mapping(target = "specie", ignore = true)
    @Mapping(target = "comments", qualifiedByName = "commentWithoutAnimal")
    AnimalModel toAnimalModel(AnimalEntity animalEntity);

    @Named("commentWithoutAnimal")
    @Mapping(target = "animal", ignore = true)
    @Mapping(target = "replies", qualifiedByName = "replyWithoutParent")
    //@Mapping(target = "parentComment", ignore = true) //Los comentarios padres tienen parentComment en null por eso no se coloca porque no entraria en ciclo. Pero se debe colocar si los comentarios hijos (respuestas) van a tener un animal_id ya que si tienen un animal_id se va a traer tambien a los comentarios hijos en la consulta y estos comentarios hijos si tienen un parentComment el cual se va a llamar y llamar entrando en ciclo. Si las respuestas no van a tener un animal_id entonces dejarlo comentado ya que no vendrian en la consulta. 
    CommentModel toCommentModel(CommentEntity commentEntity);

    @Named("replyWithoutParent")
    @Mapping(target = "parentComment", ignore = true)
    @Mapping(target = "replies", ignore = true)
    //@Mapping(target = "animal", ignore = true) //No se coloca porque no es necesario ya que los comentarios hijos (respuestas) tienen animal_id en null y por tanto no entraría en ciclo. Pero se debe descomentar si los comentarios hijos van a tener un animal_id ya que va a llamar a animal y luego animal llamaría a comentarios entrando en ciclo
    CommentModel toModel(CommentEntity commentEntity);
}
