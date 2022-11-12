package ru.pochinka.pet.project.bankproject.conroller

import ru.pochinka.pet.project.bankproject.service.CountService
import spock.lang.Specification

class CountControllerTest extends Specification {

    def countService = Mock(CountService)

    def controller = new CountController(countService)

    def "GetByCount"() {
        setup:
        def count = "123456789123456789"
        when:
        controller.getByCount(count)
        then:
        1 * countService.getByCount(count)
    }
}
