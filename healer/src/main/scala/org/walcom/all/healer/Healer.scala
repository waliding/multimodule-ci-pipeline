package org.walcom.all.healer

import org.walcom.all.model._

object Healer {

  def heal(person: Person, miracle: Miracle): Person = {
    if(miracle.is_happening) person.copy(infected = false, immune = true) else person
  }

}
