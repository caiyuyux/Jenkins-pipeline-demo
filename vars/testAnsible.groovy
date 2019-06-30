#!/usr/bin/env groovy

def call(String name = 'human') {
  echo "Hello World."

  pipeline {
    agent any

    stages {
        stage('test') {
		steps {
		     ansiblePlaybook(
		        inventory: 'local_inventory/hosts.cfg',
		        playbook: 'cloud_playbooks/create-aws.yml',
		        extraVars: [
		            login: 'mylogin',
		            secret_key: [value: 'g4dfKWENpeF6pY05', hidden: true]
		        ])}
	}
    }
  }
}
