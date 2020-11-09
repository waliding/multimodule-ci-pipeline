package org.walcom.all.healer

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.walcom.all.model.{Miracle, Person}


class HealerSpec extends AnyFlatSpec with Matchers {

  val person_immune = Person("You", infected = false, immune = true)
  val person_not_immune = Person("Batman", infected = false, immune = false)
  val person_infected_not_immune = Person("Pixou", infected = true, immune = false)

  val miracle_is_happening = Miracle("Bouyaaa", true)
  val miracle_is_not_happening = Miracle("Abracadabra", false)

  "heal" should "return same Person with infected = false and immune = true when miracle is happening" in {

    val input_person = person_infected_not_immune
    val input_miracle = miracle_is_happening

    val expected = person_infected_not_immune.copy(infected = false, immune = true)

    val result = Healer.heal(input_person, input_miracle)

    result shouldEqual expected
  }

  it should "return same Person with infected = true and immune = false when miracle is not happening" in {

    val input_person = person_infected_not_immune
    val input_miracle = miracle_is_not_happening

    val expected = person_infected_not_immune

    val result = Healer.heal(input_person, input_miracle)

    result shouldEqual expected
  }

  it should "return same Person with infected = false and immune = true when miracle is not happening" in {

    val input_person = person_immune
    val input_miracle = miracle_is_not_happening

    val expected = person_immune

    val result = Healer.heal(input_person, input_miracle)

    result shouldEqual expected
  }

}
