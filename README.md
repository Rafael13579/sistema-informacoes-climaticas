# 🌤️ Sistema de Informações Climáticas em Tempo Real

Este projeto é um **aplicativo em Java** que consome a API [WeatherAPI](https://www.weatherapi.com/) para exibir **informações meteorológicas em tempo real** de qualquer cidade do mundo.  
Ele utiliza `HttpClient` para fazer requisições HTTP e a biblioteca `org.json` para processar os dados recebidos em JSON.

---

## 🚀 Funcionalidades
- Consulta dados climáticos em tempo real a partir do nome da cidade.
- Exibe:
  - 🌡️ Temperatura atual  
  - 🤔 Sensação térmica  
  - ⛅ Condição do tempo  
  - 💧 Umidade  
  - 🌬️ Velocidade do vento  
  - 📊 Pressão atmosférica  
  - 🕒 Data e hora local da cidade pesquisada  

---

## 🛠️ Tecnologias utilizadas
- **Java 22**
- **HttpClient** (para consumir a API)
- **org.json** (para parsear o JSON)
- **WeatherAPI** (fonte dos dados meteorológicos)

---

## 📂 Estrutura do projeto
- ProjetoSistemaDeInformacoesClimaticasEmTempoReal/
- ├── src/
- │   └── ProjetoSistemaDeInformacoesClimaticasEmTempoReal.java
- ├── api-key.txt          # arquivo contendo a chave da WeatherAPI
- └── README.md

---

## ⚙️ Como rodar o projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/projeto-clima.git
   cd projeto-clima
   Configure a chave da API:

2. **Configure a chave da API:**
    - Crie uma conta gratuita em WeatherAPI
    - Copie a chave gerada
    - Salve a chave dentro de um arquivo chamado api-key.txt
  
3. **Compile e execute:**
    - javac -cp ".;lib/json-20230227.jar" src/ProjetoSistemaDeInformacoesClimaticasEmTempoReal.java
    - java -cp ".;lib/json-20230227.jar;src" ProjetoSistemaDeInformacoesClimaticasEmTempoReal
  
---

## 📖 O que aprendi com este projeto
- Como consumir APIs REST em Java usando HttpClient.
- Como trabalhar com JSON usando a biblioteca org.json.
- Diferença entre requisições GET e POST.
- Como lidar com acentos e codificação UTF-8 no Java.


---

## 🔮 Possíveis melhorias futuras
- Criar uma interface gráfica (JavaFX ou Swing).
- Permitir salvar consultas anteriores em arquivo.
- Implementar previsão para os próximos dias.
- Criar versão em Spring Boot com API REST própria.






✍️ Autor: Rafael Fernandes da Silva

