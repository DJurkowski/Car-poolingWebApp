<nav style="background:#383a39 !important" class="navbar navbar-expand-md navbar-dark fixed-top">
    <a class="navbar-brand" href="/"><strong>TASKER</strong>_App</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/about">About</a>
            </li>
        </ul>
        <ul class="navbar-nav navbar-right">
            {% if session.logged_in %}
            <li class="nav-item">
                <a class="nav-link btn btn-outline-success" href="/tasksList">Tasks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/add_task">Add Task</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
            {% else %}
            <li class="nav-item">
                <a class="nav-link" href="/register">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-outline-success" href="/login">Login</a>
            </li>
            {% endif %}
        </ul>

    </div>
</nav>