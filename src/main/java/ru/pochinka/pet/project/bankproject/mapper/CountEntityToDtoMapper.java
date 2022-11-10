package ru.pochinka.pet.project.bankproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.pochinka.pet.project.bankproject.dto.CountDto;
import ru.pochinka.pet.project.bankproject.entity.CountEntity;
import ru.pochinka.pet.project.bankproject.enums.Currency;

@Mapper(componentModel = "spring")
public interface CountEntityToDtoMapper {

    @Mapping(target = "currency", source = "currency", qualifiedByName = "mapCurrency")
    CountDto sourceToDestination(CountEntity source);

    @Mapping(target = "currency", source = "currency", qualifiedByName = "mapCurrencyEnum")
    CountEntity destinationToSource(CountDto source);

    @Named("mapCurrency")
    default String mapCurrency(Currency currency) {
        return currency.getDisplayName();

    }

    @Named("mapCurrencyEnum")
    default Currency mapCurrencyEnum(String currency){
        return Currency.valueOf(currency);
    }
}
