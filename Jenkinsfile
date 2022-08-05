@Library('ci-cd-shared-libs') _

pipeline {
    agent any
    options {
    timestamps()
    ansiColor('xterm')
    }
    stages {
        stage('Checkout Stage') {
            steps {
               git branch: 'main',
                   url: 'https://github.com/EwelinaCh/ci-cd-shared-libs.git'
            }
        }
         stage('Matrix Stage') {
             matrix {
                      axes {
                         axis {
                            name 'TASK'
                            values 'linters', 'py32', 'docs'
                          }
                      }
                      stages {
                          stage('TASK ${TASK}') {
                              steps {
                                echo "Run ${TASK}"
                                tox("${TASK}")
                              }
                          }
                    }
                }
            }
        }
    }
