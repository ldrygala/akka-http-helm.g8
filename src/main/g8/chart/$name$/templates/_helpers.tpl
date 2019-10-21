{{/*
Expand the name of the chart.
*/}}
{{- define "$name$.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "$name$.fullname" -}}
{{- if .Values.fullnameOverride -}}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- \$name := default .Chart.Name .Values.nameOverride -}}
{{- if contains \$name .Release.Name -}}
{{- .Release.Name | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- printf "%s-%s" .Release.Name \$name | trunc 63 | trimSuffix "-" -}}
{{- end -}}
{{- end -}}
{{- end -}}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "$name$.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" -}}
{{- end -}}


{{- define "app.name" -}}
{{- \$suffix := "app" -}}
{{- \$truncNum := len \$suffix | int64 | sub 62 | int -}}
{{- printf "%s-%s" (include "$name$.name" . | trunc \$truncNum) \$suffix -}}
{{- end -}}

{{- define "app.fullname" -}}
{{- \$suffix := "app" -}}
{{- \$truncNum := len \$suffix | sub 62 | int -}}
{{- printf "%s-%s" (include "$name$.fullname" . | trunc \$truncNum) \$suffix -}}
{{- end -}}

{{- define "app.image" -}}
{{- \$tag := default "latest" .Values.$name;format="word-space,camel"$.image.tag -}}
{{- printf "%s:%s" .Values.$name;format="word-space,camel"$.image.name \$tag -}}
{{- end -}}

{{- define "listWithComma" -}}
{{- \$local := dict "first" true -}}
[{{- range \$k, \$v := . -}}{{- if not \$local.first -}},{{- end -}}{{- \$v -}}{{- \$_ := set \$local "first" false -}}{{- end -}}]
{{- end -}}