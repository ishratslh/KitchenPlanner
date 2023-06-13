# Merge

Pour merger une branche (`branche_a` vers `branche_b`) :
* Créer une merge request via Gitlab
* En local, mettre à jour `branche_a` et `branche_b` (fetch, et éventuellement pull)
* En local, effectuer le merge de `branche_b` vers `branche_a` (`$ git merge branche_b branche_a`)
  -> en cas de conflit, les traiter via Atom, puis valider le merge commit
* Push la branche `branche_a`
* Effectuer le merge depuis gitlab
* En local, mettre à jour `branche_b`
