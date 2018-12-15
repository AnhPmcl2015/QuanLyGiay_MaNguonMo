package com.shoe.converter;

public abstract class BaseDtoConverter<Entity, Dto> {
	public abstract void convertEntityToDto(Entity entity, Dto dto);
}
