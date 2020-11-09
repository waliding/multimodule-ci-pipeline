package org.walcom.all.propagator

import org.walcom.all.model._

object Propagator {

  def infect(virus: Virus, person: Person): Person = {
    if(virus.active && !person.immune) person.copy(infected = true) else person
  }

}
