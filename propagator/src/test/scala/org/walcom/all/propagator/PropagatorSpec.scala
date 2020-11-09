package org.walcom.all.propagator

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.walcom.all.model.{Person, Virus}


class PropagatorSpec extends AnyFlatSpec with Matchers {

  val virus_active = Virus("Sars-Cov-2", "coronavirus", true)
  val virus_inactive = Virus("Sars-Cov-2", "coronavirus", false)

  val person_immune = Person("You", infected = false, immune = true)
  val person_not_immune = Person("Batman", infected = false, immune = false)

  "infect" should "return same Person with infected = false when person is immune and virus is active" in {

    val input_person = person_immune
    val input_virus = virus_active

    val expected = person_immune

    val result = Propagator.infect(input_virus, input_person)

    result shouldEqual expected

  }

  it should "return same Person with infected = false when person is immune and virus is not active" in {

    val input_person = person_immune
    val input_virus = virus_inactive

    val expected = person_immune

    val result = Propagator.infect(input_virus, input_person)

    result shouldEqual expected
  }

  it should "return same Person with infected = false when person is not immune and virus is not active" in {

    val input_person = person_not_immune
    val input_virus = virus_inactive

    val expected = person_not_immune

    val result = Propagator.infect(input_virus, input_person)

    result shouldEqual expected
  }

  it should "return same Person with infected = true when person is not immune and virus is active" in {

    val input_person = person_not_immune
    val input_virus = virus_active

    val expected = input_person.copy(infected = true)

    val result = Propagator.infect(input_virus, input_person)

    result shouldEqual expected
  }

}
