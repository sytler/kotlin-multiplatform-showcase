package component

import react.RProps
import react.functionalComponent
import styled.css
import styled.styledImg

private val bannerBase64 =
    "data:image/svg+xml;base64,PHN2ZyBmaWxsPSJub25lIiBoZWlnaHQ9IjMxMCIgdmlld0JveD0iMCAwIDc1NSAzMTAiIHdpZHRoPSI3NTUiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiPjxjbGlwUGF0aCBpZD0iYSI+PHBhdGggZD0ibTAgMGg0OTAuODYxdjk4aC00OTAuODYxeiIvPjwvY2xpcFBhdGg+PGNsaXBQYXRoIGlkPSJiIj48cGF0aCBkPSJtMCAyMTJoNTExLjI5djk4aC01MTEuMjl6Ii8+PC9jbGlwUGF0aD48ZyBjbGlwLXBhdGg9InVybCgjYSkiPjxwYXRoIGQ9Im04My40MDQxIDg0LjM2MmM1LjAxMzkgNS4wNDc0IDEuNDM4OCAxMy42MzgtNS42NzU3IDEzLjYzOGgtNzcuNzI4NHYtOThoNzcuNzI4NWM3LjExNDQgMCAxMC42ODk1IDguNTkwNjQgNS42NzU2IDEzLjYzOGwtMzUuMTI3NCAzNS4zNjJ6IiBmaWxsPSIjZmY2YzBhIi8+PHBhdGggZD0ibTEwNC45NTIgNDljMC0yNy4wNjIgMjEuOTM4LTQ5IDQ5LTQ5aDE4MmMyNy4wNjIgMCA0OSAyMS45MzggNDkgNDkgMCAyNy4wNjItMjEuOTM4IDQ5LTQ5IDQ5aC0xODJjLTI3LjA2MiAwLTQ5LTIxLjkzOC00OS00OXoiIGZpbGw9IiMzODM5M2YiLz48cGF0aCBkPSJtMTU1LjA4IDc1aDUuNjg4di0xMy41MzZsMTAuNzI4LTEwLjg3MiAxOS4zNjggMjQuNDA4aDcuMTI4bC0yMi41MzYtMjguMzY4IDIxLjY3Mi0yMi4wMzJoLTcuNDE2bC0yOC45NDQgMzAuMDk2di0zMC4wOTZoLTUuNjg4em02Mi43NDYuODY0YzExLjIzMiAwIDE5LjUxMi04LjkyOCAxOS41MTItMTkuNDR2LS4xNDRjMC0xMC41MTItOC4yMDgtMTkuMjk2LTE5LjM2OC0xOS4yOTYtMTEuMjMyIDAtMTkuNDQgOC45MjgtMTkuNDQgMTkuNDR2LjE0NGMwIDEwLjUxMiA4LjEzNiAxOS4yOTYgMTkuMjk2IDE5LjI5NnptLjE0NC00Ljk2OGMtNy44NDggMC0xMy43NTItNi40OC0xMy43NTItMTQuNDcydi0uMTQ0YzAtNy44NDggNS41NDQtMTQuNCAxMy42MDgtMTQuNCA3Ljg0OCAwIDEzLjgyNCA2LjU1MiAxMy44MjQgMTQuNTQ0di4xNDRjMCA3Ljg0OC01LjYxNiAxNC4zMjgtMTMuNjggMTQuMzI4em0zOC45ODcgNC43NTJjMi42NjQgMCA0Ljc1Mi0uNTc2IDYuNjk2LTEuNTg0di00Ljc1MmMtMS45NDQuOTM2LTMuNTI4IDEuMjk2LTUuNCAxLjI5Ni0zLjc0NCAwLTYuMjY0LTEuNjU2LTYuMjY0LTYuMTkydi0yMS43NDRoMTEuODA4di00Ljg5NmgtMTEuODA4di0xMS4yMzJoLTUuNTQ0djExLjIzMmgtNS4xODR2NC44OTZoNS4xODR2MjIuNDY0YzAgNy41NiA0LjUzNiAxMC41MTIgMTAuNTEyIDEwLjUxMnptMTQuMjc3LS42NDhoNS41NDR2LTUyLjU2aC01LjU0NHptMTUuNjc0LTQ1LjM2aDYuMzM2di02LjEyaC02LjMzNnptLjM2IDQ1LjM2aDUuNTQ0di0zNy4yMjRoLTUuNTQ0em0xNS41MyAwaDUuNTQ0di0yMS4zMTJjMC02Ljk4NCA0Ljc1Mi0xMS42NjQgMTEuMTYtMTEuNjY0IDYuNTUyIDAgMTAuMjk2IDQuMzIgMTAuMjk2IDExLjIzMnYyMS43NDRoNS41NDR2LTIzLjExMmMwLTguODU2LTUuMjU2LTE0LjkwNC0xNC4yNTYtMTQuOTA0LTYuNDA4IDAtMTAuMjk2IDMuMjQtMTIuNzQ0IDcuMjcydi02LjQ4aC01LjU0NHoiIGZpbGw9IiNmZmYiLz48cGF0aCBkPSJtNDQxLjkwNiA5Ny45NTQ3YzI3LjAzNyAwIDQ4Ljk1NS0yMS45MTc3IDQ4Ljk1NS00OC45NTQ2cy0yMS45MTgtNDguOTU0Njg5OC00OC45NTUtNDguOTU0Njg5OC00OC45NTQgMjEuOTE3Nzg5OC00OC45NTQgNDguOTU0Njg5OCAyMS45MTcgNDguOTU0NiA0OC45NTQgNDguOTU0NnoiIGZpbGw9IiM2YjcwZmMiLz48L2c+PHBhdGggZD0ibTQ3LjEyNTEgMTEwLjExN2MzLjExNC01LjQ4OSAxMC42MzU4LTUuNDg5IDEzLjc0OTggMGw0NS45NzAxIDgxLjA0YzMuMjA2IDUuNjUyLS42NDMgMTIuODQzLTYuODc0OCAxMi44NDNoLTkxLjk0MDQyYy02LjIzMTg4IDAtMTAuMDgxMTQtNy4xOTEtNi44NzQ4Ni0xMi44NDN6IiBmaWxsPSIjNmI3MGZjIi8+PHBhdGggZD0ibTExNiAxNjkuOTFoMjMuNjA2YzIuODg5IDAgNS42NTkgMS4xNDcgNy43MDEgMy4xOSAyLjA0MyAyLjA0MyAzLjE5IDQuODEzIDMuMTkgNy43MDJ2MjMuMTUzaDI4LjkxNXYtMjMuMTQ4Yy0uMDAxLTEuNDMuMjgtMi44NDcuODI3LTQuMTcuNTQ3LTEuMzIyIDEuMzQ5LTIuNTIzIDIuMzYxLTMuNTM1IDEuMDExLTEuMDEyIDIuMjEyLTEuODE1IDMuNTM0LTIuMzYzIDEuMzIyLS41NDcgMi43MzgtLjgyOSA0LjE2OS0uODI5aDIzLjYwNnYtMjkuODE0aC0yMy42MDZjLTIuODg4IDAtNS42NTktMS4xNDgtNy43MDEtMy4xOS0yLjA0My0yLjA0My0zLjE5LTQuODEzLTMuMTktNy43MDJ2LTIzLjE1OWgtMjguOTE1djIzLjE1OWMwIDIuODg5LTEuMTQ3IDUuNjU5LTMuMTkgNy43MDItMi4wNDIgMi4wNDItNC44MTIgMy4xOS03LjcwMSAzLjE5aC0yMy42MDZ6IiBmaWxsPSIjNDVkYmI3Ii8+PHBhdGggZD0ibTIyMS45MDkgMTU1YzAtMjcuMDYyIDIxLjkzOC00OSA0OS00OWg0MzVjMjcuMDYyIDAgNDkgMjEuOTM4IDQ5IDQ5IDAgMjcuMDYyLTIxLjkzOCA0OS00OSA0OWgtNDM1Yy0yNy4wNjIgMC00OS0yMS45MzgtNDktNDl6IiBmaWxsPSIjMzgzOTNmIi8+PHBhdGggZD0ibTI3Mi4wMzcgMTgxaDUuNTQ0di00MC43NTJsMTguMzYgMjYuOTI4aC4yODhsMTguMzYtMjd2NDAuODI0aDUuNjg4di01MC40aC01Ljc2bC0xOC4zNiAyNy41MDQtMTguMzYtMjcuNTA0aC01Ljc2em03Mi4zNzIuNzkyYzYuNDA4IDAgMTAuMjI0LTMuMjQgMTIuNzQ0LTcuMjcydjYuNDhoNS40NzJ2LTM3LjIyNGgtNS40NzJ2MjEuMzEyYzAgNi45ODQtNC44MjQgMTEuNjY0LTExLjE2IDExLjY2NC02LjU1MiAwLTEwLjI5Ni00LjMyLTEwLjI5Ni0xMS4yMzJ2LTIxLjc0NGgtNS41NDR2MjMuMTEyYzAgOC44NTYgNS4yNTYgMTQuOTA0IDE0LjI1NiAxNC45MDR6bTI4LjMxMS0uNzkyaDUuNTQ0di01Mi41NmgtNS41NDR6bTI3Ljk4Ni42NDhjMi42NjQgMCA0Ljc1Mi0uNTc2IDYuNjk2LTEuNTg0di00Ljc1MmMtMS45NDQuOTM2LTMuNTI4IDEuMjk2LTUuNCAxLjI5Ni0zLjc0NCAwLTYuMjY0LTEuNjU2LTYuMjY0LTYuMTkydi0yMS43NDRoMTEuODA4di00Ljg5NmgtMTEuODA4di0xMS4yMzJoLTUuNTQ0djExLjIzMmgtNS4xODR2NC44OTZoNS4xODR2MjIuNDY0YzAgNy41NiA0LjUzNiAxMC41MTIgMTAuNTEyIDEwLjUxMnptMTMuOTE4LTQ2LjAwOGg2LjMzNnYtNi4xMmgtNi4zMzZ6bS4zNiA0NS4zNmg1LjU0NHYtMzcuMjI0aC01LjU0NHptMTUuNTMgMTEuNTJoNS41NDR2LTE4LjY0OGMyLjg4IDQuMTc2IDcuMzQ0IDcuOTIgMTQuMjU2IDcuOTIgOSAwIDE3Ljc4NC03LjIgMTcuNzg0LTE5LjM2OHYtLjE0NGMwLTEyLjI0LTguODU2LTE5LjI5Ni0xNy43ODQtMTkuMjk2LTYuODQgMC0xMS4yMzIgMy44MTYtMTQuMjU2IDguMjh2LTcuNDg4aC01LjU0NHptMTguNzkyLTE1LjY5NmMtNi45MTIgMC0xMy40NjQtNS43Ni0xMy40NjQtMTQuNHYtLjE0NGMwLTguNDk2IDYuNTUyLTE0LjMyOCAxMy40NjQtMTQuMzI4IDcuMDU2IDAgMTMuMTA0IDUuNjE2IDEzLjEwNCAxNC40di4xNDRjMCA5LTUuOTA0IDE0LjMyOC0xMy4xMDQgMTQuMzI4em0yNi42NDQgNC4xNzZoNS41NDR2LTUyLjU2aC01LjU0NHptMjYuNjE4Ljc5MmM2LjU1MiAwIDEwLjg3Mi0zLjAyNCAxMy40NjQtNi40MDh2NS42MTZoNS4zMjh2LTIyLjc1MmMwLTQuNzUyLTEuMjk2LTguMzUyLTMuODE2LTEwLjg3Mi0yLjczNi0yLjczNi02Ljc2OC00LjEwNC0xMi4wMjQtNC4xMDQtNS40IDAtOS40MzIgMS4yMjQtMTMuNTM2IDMuMDk2bDEuNjU2IDQuNTM2YzMuNDU2LTEuNTg0IDYuOTEyLTIuNzM2IDExLjMwNC0yLjczNiA2Ljk4NCAwIDExLjA4OCAzLjQ1NiAxMS4wODggMTAuMTUydjEuMjk2Yy0zLjMxMi0uOTM2LTYuNjk2LTEuNTg0LTExLjQ0OC0xLjU4NC05LjQzMiAwLTE1LjkxMiA0LjE3Ni0xNS45MTIgMTIuMDI0di4xNDRjMCA3LjYzMiA2Ljk4NCAxMS41OTIgMTMuODk2IDExLjU5MnptMS4wOC00LjM5MmMtNS4wNCAwLTkuMzYtMi43MzYtOS4zNi03LjQxNnYtLjE0NGMwLTQuNjggMy44ODgtNy43MDQgMTAuODcyLTcuNzA0IDQuNTM2IDAgOC4yMDguNzkyIDEwLjk0NCAxLjU4NHYzLjZjMCA1LjkwNC01LjYxNiAxMC4wOC0xMi40NTYgMTAuMDh6bTM4Ljc1MiA0LjI0OGMyLjY2NCAwIDQuNzUyLS41NzYgNi42OTYtMS41ODR2LTQuNzUyYy0xLjk0NC45MzYtMy41MjggMS4yOTYtNS40IDEuMjk2LTMuNzQ0IDAtNi4yNjQtMS42NTYtNi4yNjQtNi4xOTJ2LTIxLjc0NGgxMS44MDh2LTQuODk2aC0xMS44MDh2LTExLjIzMmgtNS41NDR2MTEuMjMyaC01LjE4NHY0Ljg5Nmg1LjE4NHYyMi40NjRjMCA3LjU2IDQuNTM2IDEwLjUxMiAxMC41MTIgMTAuNTEyem0xNS44NjEtLjY0OGg1LjU0NHYtMzIuMzI4aDExLjczNnYtNC43NTJoLTExLjgwOHYtMy4wMjRjMC01LjMyOCAyLjE2LTcuOTIgNi40OC03LjkyIDEuODcyIDAgMy4zODQuMzYgNS40LjkzNnYtNC44MjRjLTEuOC0uNjQ4LTMuNTI4LS45MzYtNi4xMi0uOTM2LTMuMzg0IDAtNi4xMiAxLjAwOC03Ljk5MiAyLjg4LTIuMDg4IDIuMDg4LTMuMjQgNS4zMjgtMy4yNCA5LjU3NnYzLjI0aC01LjExMnY0LjgyNGg1LjExMnptMzcuNzU5Ljg2NGMxMS4yMzIgMCAxOS41MTItOC45MjggMTkuNTEyLTE5LjQ0di0uMTQ0YzAtMTAuNTEyLTguMjA4LTE5LjI5Ni0xOS4zNjgtMTkuMjk2LTExLjIzMiAwLTE5LjQ0IDguOTI4LTE5LjQ0IDE5LjQ0di4xNDRjMCAxMC41MTIgOC4xMzYgMTkuMjk2IDE5LjI5NiAxOS4yOTZ6bS4xNDQtNC45NjhjLTcuODQ4IDAtMTMuNzUyLTYuNDgtMTMuNzUyLTE0LjQ3MnYtLjE0NGMwLTcuODQ4IDUuNTQ0LTE0LjQgMTMuNjA4LTE0LjQgNy44NDggMCAxMy44MjQgNi41NTIgMTMuODI0IDE0LjU0NHYuMTQ0YzAgNy44NDgtNS42MTYgMTQuMzI4LTEzLjY4IDE0LjMyOHptMjYuNTMxIDQuMTA0aDUuNTQ0di0xNC44MzJjMC0xMS4yMzIgNi42MjQtMTcuMDY0IDE0Ljc2LTE3LjA2NGguNDMydi01Ljk3NmMtNy4wNTYtLjI4OC0xMi40NTYgNC4xNzYtMTUuMTkyIDEwLjM2OHYtOS43MmgtNS41NDR6bTI2LjI5OSAwaDUuNTQ0di0yMS4yNGMwLTYuODQgNC40NjQtMTEuNzM2IDEwLjM2OC0xMS43MzZzOS41NzYgNC4xMDQgOS41NzYgMTEuMDg4djIxLjg4OGg1LjQ3MnYtMjEuNDU2YzAtNy4zNDQgNC42OC0xMS41MiAxMC4yOTYtMTEuNTIgNi4wNDggMCA5LjY0OCA0LjAzMiA5LjY0OCAxMS4yMzJ2MjEuNzQ0aDUuNTQ0di0yMy4wNGMwLTkuMjE2LTUuMjU2LTE0Ljk3Ni0xMy44MjQtMTQuOTc2LTYuNDggMC0xMC40NCAzLjMxMi0xMy4xMDQgNy40MTYtMi4wMTYtNC4xNzYtNS45MDQtNy40MTYtMTEuOTUyLTcuNDE2LTYuMjY0IDAtOS41NzYgMy4zODQtMTIuMDI0IDcuMDU2di02LjI2NGgtNS41NDR6IiBmaWxsPSIjZmZmIi8+PGcgY2xpcC1wYXRoPSJ1cmwoI2IpIj48cGF0aCBkPSJtMCAyNjFjMC0yNy4wNjIgMjEuOTM4LTQ5IDQ5LTQ5aDIxMWMyNy4wNjIgMCA0OSAyMS45MzggNDkgNDkgMCAyNy4wNjItMjEuOTM4IDQ5LTQ5IDQ5aC0yMTFjLTI3LjA2MTkgMC00OS0yMS45MzgtNDktNDl6IiBmaWxsPSIjMzgzOTNmIi8+PHBhdGggZD0ibTUwLjEyOCAyODdoNS41NDR2LTQwLjc1MmwxOC4zNiAyNi45MjhoLjI4OGwxOC4zNi0yN3Y0MC44MjRoNS42ODh2LTUwLjRoLTUuNzZsLTE4LjM2IDI3LjUwNC0xOC4zNi0yNy41MDRoLTUuNzZ6bTc1LjY4NC44NjRjMTEuMjMyIDAgMTkuNTEyLTguOTI4IDE5LjUxMi0xOS40NHYtLjE0NGMwLTEwLjUxMi04LjIwOC0xOS4yOTYtMTkuMzY4LTE5LjI5Ni0xMS4yMzIgMC0xOS40NCA4LjkyOC0xOS40NCAxOS40NHYuMTQ0YzAgMTAuNTEyIDguMTM2IDE5LjI5NiAxOS4yOTYgMTkuMjk2em0uMTQ0LTQuOTY4Yy03Ljg0OCAwLTEzLjc1Mi02LjQ4LTEzLjc1Mi0xNC40NzJ2LS4xNDRjMC03Ljg0OCA1LjU0NC0xNC40IDEzLjYwOC0xNC40IDcuODQ4IDAgMTMuODI0IDYuNTUyIDEzLjgyNCAxNC41NDR2LjE0NGMwIDcuODQ4LTUuNjE2IDE0LjMyOC0xMy42OCAxNC4zMjh6bTQ2LjMzMSA0Ljg5NmM5IDAgMTcuNzg0LTcuMiAxNy43ODQtMTkuMzY4di0uMTQ0YzAtMTIuMjQtOC44NTYtMTkuMjk2LTE3Ljc4NC0xOS4yOTYtNi44NCAwLTExLjIzMiAzLjgxNi0xNC4yNTYgOC4yOHYtMjIuODI0aC01LjU0NHY1Mi41Nmg1LjU0NHYtNy4xMjhjMi44OCA0LjE3NiA3LjM0NCA3LjkyIDE0LjI1NiA3Ljkyem0tMS4wMDgtNC45NjhjLTYuOTEyIDAtMTMuNDY0LTUuNzYtMTMuNDY0LTE0LjR2LS4xNDRjMC04LjQ5NiA2LjU1Mi0xNC4zMjggMTMuNDY0LTE0LjMyOCA3LjA1NiAwIDEzLjEwNCA1LjYxNiAxMy4xMDQgMTQuNHYuMTQ0YzAgOS01LjkwNCAxNC4zMjgtMTMuMTA0IDE0LjMyOHptMjYuMjg0LTQxLjE4NGg2LjMzNnYtNi4xMmgtNi4zMzZ6bS4zNiA0NS4zNmg1LjU0NHYtMzcuMjI0aC01LjU0NHptMTYuMDM0IDBoNS41NDR2LTUyLjU2aC01LjU0NHptMzEuODAyLjg2NGM3LjA1NiAwIDExLjU5Mi0yLjgwOCAxNS4zMzYtNi45ODRsLTMuNDU2LTMuMDk2Yy0zLjAyNCAzLjE2OC02LjYyNCA1LjI1Ni0xMS43MzYgNS4yNTYtNi42MjQgMC0xMi4zMTItNC41MzYtMTMuMTA0LTEyLjZoMjkuNTJjLjA3Mi0uNjQ4LjA3Mi0xLjA4LjA3Mi0xLjggMC0xMC44NzItNi4zMzYtMTkuNjU2LTE3LjM1Mi0xOS42NTYtMTAuMjk2IDAtMTcuODU2IDguNjQtMTcuODU2IDE5LjM2OHYuMTQ0YzAgMTEuNTIgOC4zNTIgMTkuMzY4IDE4LjU3NiAxOS4zNjh6bS0xMi45Ni0yMS41MjhjLjcyLTcuMjcyIDUuNjE2LTEyLjY3MiAxMi4wOTYtMTIuNjcyIDcuNDE2IDAgMTEuMzA0IDUuOTA0IDExLjg4IDEyLjY3MnoiIGZpbGw9IiNmZmYiLz48cGF0aCBkPSJtMzczLjE5MiAyMjAuOTU4IDMuODM5IDEyLjUzOSAxMi43NzItMi45NDVjMTIuMTEzLTIuNzkzIDIwLjUyNCAxMS43NzcgMTIuMDUxIDIwLjg2NGwtOC45NCA5LjYwNSA4Ljk0IDkuNTg4YzguNDczIDkuMDk5LjA2MiAyMy42NjMtMTIuMDUxIDIwLjg3MWwtMTIuNzcyLTIuOTQ2LTMuODM5IDEyLjUxMWMtMy42MzQgMTEuODgtMjAuNDcyIDExLjg4LTI0LjA5NSAwbC0zLjgzOC0xMi41MTEtMTIuNzczIDIuOTQ2Yy0xMi4xMTMgMi43OTItMjAuNTIzLTExLjc3OC0xMi4wNS0yMC44NzFsOC45NC05LjU4OC04Ljk0LTkuNTkzYy04LjQ3My05LjA5OS0uMDYzLTIzLjY1NyAxMi4wNS0yMC44NjVsMTIuNzczIDIuOTQ2IDMuODM4LTEyLjU0YzMuNjM0LTExLjg5NiAyMC40NjEtMTEuODk2IDI0LjA5NS0uMDExeiIgZmlsbD0iIzZiNzBmYyIvPjxyZWN0IGZpbGw9IiM0NWRiYjciIGhlaWdodD0iOTgiIHJ4PSI4IiB3aWR0aD0iOTgiIHg9IjQxMy4yOSIgeT0iMjEyIi8+PC9nPjwvc3ZnPg=="


val Banner = functionalComponent<RProps> {
    styledImg(src = bannerBase64) {
        css(Styles.banner)
    }
}