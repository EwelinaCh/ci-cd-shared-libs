pipeline {
    agent none 
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
                  agent any
                      axes {
                         axis {
                            name 'TARGET'
                            values 'linters', 'py32', 'docs'
                          }
                      }
                      stages {
                          stage('Build') {
                              steps {
                                echo "Run ${TARGET}"
                                  sh 'tox -e ${TARGET}'
                              }
                          }
                    }
                }
            }
        }
    }
