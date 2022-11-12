package ru.pochinka.pet.project.bankproject.facade

import ru.pochinka.pet.project.bankproject.dto.CardDto
import ru.pochinka.pet.project.bankproject.dto.CountDto
import ru.pochinka.pet.project.bankproject.dto.request.RequestCardDto
import ru.pochinka.pet.project.bankproject.entity.CardEntity
import ru.pochinka.pet.project.bankproject.facade.impl.CardFacadeImpl
import ru.pochinka.pet.project.bankproject.mapper.CardEntityToDtoMapper
import ru.pochinka.pet.project.bankproject.service.CardService
import spock.lang.Specification

class CardFacadeTest extends Specification {

    def cardService = Mock(CardService)
    def cardMapper = Mock(CardEntityToDtoMapper)

    def facade = new CardFacadeImpl(cardService, cardMapper)


    def "Save"() {
        setup:
        def card = new CardEntity()
        def cardDto = new CardDto(cardNumber: 123123, count: Mock(CountDto))
        def requestCardDto = new RequestCardDto(cardDto: cardDto, userId: UUID.randomUUID())
        and:
        cardMapper.destinationToSource(cardDto) >> card
        when:
        facade.save(requestCardDto)
        then:
        1 * cardService.save(card)


    }

    def "Delete"() {
        setup:
        def cardNumber = (BigInteger) 1234123412341234
        when:
        facade.delete(cardNumber)
        then:
        1 * cardService.deleteCardByNumber(cardNumber)

    }
}
