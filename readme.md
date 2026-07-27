# DukeQuill API 🪶

API REST del corrector ortográfico y gramatical DukeQuill, desarrollada con Spring Boot. Expone los motores de análisis de DukeQuill como endpoints HTTP para ser consumidos por cualquier cliente web o móvil.

---

## Endpoints

### `POST /api/analyze`

Analiza un texto en español y devuelve los errores encontrados.

**Request:**
```
Content-Type: text/plain
Body: El texto a analizar
```

**Response:**
```json
{
  "spellErrors": [
    {
      "word": "cafe",
      "line": 1,
      "position": 3,
      "suggestions": ["café", "gafe", "cabe"]
    }
  ],
  "ruleViolations": [
    {
      "rule": "Punto Final",
      "message": "Falta el punto final 'texto'",
      "line": 1,
      "position": 28
    }
  ],
  "accentErrors": [
    {
      "word": "cafe",
      "position": 3,
      "suggestion": "café"
    }
  ]
}
```

---

## Tipos de errores detectados

**Errores ortográficos** (`spellErrors`) — palabras que no existen en el diccionario español ni son reconocidas morfológicamente. Incluye sugerencias usando el algoritmo Damerau-Levenshtein.

**Violaciones de reglas** (`ruleViolations`) — errores de puntuación y gramática:
- Signos de interrogación y exclamación sin cerrar/abrir
- Falta de espacio después de puntuación
- Espacio antes de puntuación
- Falta de mayúscula después de punto
- Falta de punto al final de oración
- Concordancia de género (artículo + sustantivo)

**Errores de acento** (`accentErrors`) — palabras con acento incorrecto según el contexto, detectadas con LanguageTool.

---

## Estructura del proyecto

```
dukequill-api/
├── src/main/java/com/dukequill/dukequill_api/
│   ├── DukequillApiApplication.java    # Punto de entrada Spring Boot
│   ├── AnalyzerController.java         # Controlador REST
│   ├── AnalysisResponse.java           # Objeto de respuesta
│   ├── dto/                            # Data Transfer Objects
│   │   ├── SpellErrorDTO.java
│   │   ├── RuleViolationDTO.java
│   │   └── AccentErrorDTO.java
│   ├── lexer/                          # Tokenizador
│   ├── dictionary/                     # Diccionario Hunspell
│   ├── analyzer/                       # Motor de análisis
│   └── rules/                          # Reglas gramaticales
└── src/main/resources/
    └── dictionary/
        ├── Spanish.dic
        └── Spanish.aff
```

---

## Dependencias

| Dependencia | Versión | Uso |
|---|---|---|
| Spring Boot | 4.1.0 | Framework REST |
| Java | 21 | Lenguaje principal |
| LanguageTool (`language-es`) | 6.3 | Morfología y acentos |
| Apache PDFBox | 3.0.1 | Soporte futuro para PDF |
| Maven | 3.9+ | Gestión de dependencias |

---

## Cómo ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/tuusuario/dukequill-api.git
cd dukequill-api

# Ejecutar
./mvnw spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

---

## Proyecto relacionado

- **[DukeQuill Desktop](https://github.com/tuusuario/dukequill)** — aplicación de escritorio Java/Swing
- **[DukeQuill Web](https://github.com/tuusuario/dukequill-web)** — frontend web

---

*Parte del ecosistema DukeQuill 🪶*