#!/usr/bin/env groovy

def call() {
  echo "Hello ${animal}."

  pipeline {
    agent any
    parameters {
        choice(choices: ['US-EAST-1', 'US-WEST-2'], description: '选择一个动物环境', name: 'animal')
        choice(choices: ['dealer', 'platform'], description: '选择要发布的项目', name: 'project')
    }

    stages {
            stage('test ansible') {

                steps {

                  ansiblePlaybook( 
                          playbook: "/var/pipeline-library/ansible/tasks/main.yml",
                          inventory: "/var/pipeline-library/ansible/hosts", 
                          extras: '-e parameter="some value"')
                }
            }
    }}
 }
