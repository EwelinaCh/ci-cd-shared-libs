def call(task) {
  sh "tox -e ${task}"
}
