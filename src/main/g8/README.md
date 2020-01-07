# $name$

## setup
### drone codecov secret
- get codecov token from [codecov.io](https://codecov.io/gh/$organization$/$name$/settings)
- set it in drone using `drone secret add --name $drone_codecov_secret$ --data <codecov_token> $organization$/$name$`