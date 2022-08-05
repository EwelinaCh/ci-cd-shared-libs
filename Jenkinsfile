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
               git branch: 'master',
                   url: 'https://opendev.org/jjb/jenkins-job-builder.git'
            }
        }
         stage('Matrix Stage') {
             matrix {
                      axes {
                         axis {
                            name 'TASK'
                            values 'linters', 'cover', 'docs'
                          }
                      }
                      stages {
                          stage('TASKS') {
                              steps {
                                echo "Run ${TASK}"
                                tox("${TASK}")
                              }
                          }
                    }
                }
            }
        }
    
    post {
        always {
            bat "tox -e cover"
        }
    }
}
