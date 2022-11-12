package ru.pochinka.pet.project.bankproject.conroller

import ru.pochinka.pet.project.bankproject.dto.request.RequestCardDto
import ru.pochinka.pet.project.bankproject.facade.CardFacade
import ru.pochinka.pet.project.bankproject.service.CardService
import spock.lang.Specification

class CardControllerTest extends Specification {

    def cardService = Mock(CardService)
    def cardFacade = Mock(CardFacade)

    def controller = new CardController(cardService, cardFacade)

    def "GetByCardNumber"() {
        setup:
        def cardNumber = "1234123412341234"
        when:
        controller.getByCardNumber(cardNumber)
        then:
        1 * cardService.getByCardNumber(cardNumber)
    }

    def "Add"() {
        setup:
        def card = new RequestCardDto()
        when:
        controller.add(card)
        then:
        1 * cardFacade.save(card)
    }

    def "Delete"() {
        setup:
        def cardNumber = 1234123412341234
        when:
        controller.delete(cardNumber)
        then:
        1 * cardFacade.delete(cardNumber)
    }
}
