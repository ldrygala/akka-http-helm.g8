# Helm charts for $name$

## Staging

### Install

`helm secrets install --namespace $helm_namespace$ --name staging-$name$ $name$ -f $name$/staging/values.yaml`

### Upgrade

`helm secrets upgrade staging-$name$ $name$ -f $name$/staging/values.yaml`

## Production

### Install

`helm secrets install --namespace $helm_namespace$ --name production-$name$ $name$ -f $name$/production/values.yaml`

### Upgrade

`helm secrets upgrade production-$name$ $name$ -f $name$/production/values.yaml`