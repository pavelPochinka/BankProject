package ru.pochinka.pet.project.bankproject.service

import ru.pochinka.pet.project.bankproject.entity.CardEntity
import ru.pochinka.pet.project.bankproject.exception.NotFoundException
import ru.pochinka.pet.project.bankproject.mapper.CardEntityToDtoMapper
import ru.pochinka.pet.project.bankproject.repository.CardRepository
import spock.lang.Specification

class CardServiceTest extends Specification {

    def cardRepository = Mock(CardRepository)
    def cardMapper = Mock(CardEntityToDtoMapper)

    def service = new CardService(cardRepository, cardMapper)

    def "save"() {
        setup:
        def card = new CardEntity()
        when:
        service.save(card)
        then:
        1 * cardRepository.save(card)
    }

    def "deleteCardByNumber"() {
        setup:
        def cardNumber = 1234123412341234
        when:
        service.deleteCardByNumber(cardNumber)
        then:
        1 * cardRepository.deleteByCardNumber(cardNumber)
    }

    def "getByCardNumber"() {
        setup:
        def card = new CardEntity()
        def cardNumber = "1234123412341234"
        def cardNumberNumeric = (BigInteger) 1234123412341234
        and:
        cardRepository.findByCardNumber(cardNumberNumeric) >> Optional.of(card)
        when:
        service.getByCardNumber(cardNumber)
        then:
        1 * cardMapper.sourceToDestination(card)
    }

    def "getByCardNumber not found card"() {
        setup:
        def cardNumber = "1234123412341234"
        def cardNumberNumeric = (BigInteger) 1234123412341234
        and:
        cardRepository.findByCardNumber(cardNumberNumeric) >> Optional.empty()
        when:
        service.getByCardNumber(cardNumber)
        then:
        thrown(NotFoundException)
    }

}
