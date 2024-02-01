<h1>AkrossSystem API</h1>

<p>Este projeto implementa uma API para gerenciar colaboradores e squads da AkrossSystem.</p>

<h2>Tecnologias Utilizadas</h2>

<ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>H2 Database</li>
</ul>

<h2>Pré-requisitos</h2>

<p>Antes de começar, certifique-se de ter o seguinte instalado em sua máquina:</p>

<ul>
    <li><a href="https://www.oracle.com/java/technologies/javase-downloads.html">Java JDK</a> (versão 17 ou superior)</li>
    <li><a href="https://maven.apache.org/download.cgi">Maven</a> (versão 3.9.6 ou superior)</li>
    <li><a href="https://git-scm.com/downloads">Git</a></li>
   <li>Uma IDE Java, como <a href="https://www.eclipse.org/downloads/">Eclipse</a>, <a href="https://www.jetbrains.com/idea/download/">IntelliJ IDEA</a> ou <a href="https://spring.io/tools">Spring Tools</a></li>
</ul>
</ul>

<h2>Configuração</h2>

<ol>
    <li>Clone o repositório:</li>
</ol>

<pre><code>git clone https://github.com/lroberta569/akrosssystem.git</code></pre>

<h2>Rodando o Projeto</h2>

<p>Para rodar o projeto, utilize o seguinte comando:</p>

<pre><code>mvn spring-boot:run</code></pre>

<p>Isso iniciará a aplicação Spring Boot. Navegue até <a href="http://localhost:8080">http://localhost:8080</a> no seu navegador para acessar a aplicação.</p>

<h2>Endpoints</h2>

<h3>Colaboradores</h3>

<h4>Consultar Colaborador pelo ID</h4>

<pre><code>GET /collaborator/{id}</code></pre>

<h4>Consultar Todos os Colaboradores</h4>

<pre><code>GET /collaborator/all</code></pre>

<h4>Cadastrar um Novo Colaborador</h4>

<pre><code>POST /collaborator/create</code></pre>

<p>Corpo da requisição (JSON):</p>

<pre><code>{
  "name": "Maria",
  "role": "Dev FullStack",
  "idSquad": {
      "idSquad": 1
  }
}</code></pre>

<h4>Atualizar Colaborador pelo ID</h4>

<pre><code>PUT /collaborator/update/{id}</code></pre>

<p>Corpo da requisição (JSON):</p>

<pre><code>{
  "name": "Maria",
  "role": "Dev FullStack Pleno",
  "idSquad": {
      "idSquad": 1
  }
}</code></pre>

<h4>Deletar Colaborador pelo ID</h4>

<pre><code>DELETE /collaborator/delete/{id}</code></pre>

<h3>Squads</h3>

<h4>Consultar Squad pelo ID</h4>

<pre><code>GET /squad/{id}</code></pre>

<h4>Consultar Todos os Squads</h4>

<pre><code>GET /squad/all</code></pre>

<h4>Cadastrar um Novo Squad</h4>

<pre><code>POST /squad/create</code></pre>

<p>Corpo da requisição (JSON):</p>

<pre><code>{
  "name": "Nome do Squad"
}</code></pre>

<h4>Atualizar Squad pelo ID</h4>

<pre><code>PUT /squad/update/{id}</code></pre>

<p>Corpo da requisição (JSON):</p>

<pre><code>{
  "name": "Novo Nome do Squad"
}</code></pre>

<h4>Deletar Squad pelo ID</h4>

<pre><code>DELETE /squad/delete/{id}</code></pre>
