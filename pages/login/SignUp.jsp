<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'> 
    <link rel="stylesheet" href="../../assets/css/include.css">
    <link rel="stylesheet" href="../../assets/css/login.css">
    <title>Sign Up</title>
</head>
<body>
    <div class="signUp_container">
        <div class="head">
            <span>Welcome</span>
            <h2>Sign Up</h2>
        </div>
        <div class="form">
            <form action="log?r=inscription" method="post">
                <span class="champ">
                    <label for="mail">Nom d'utilisateur</label>
                    <input type="text" name="user_name" placeholder="Ex:Tahina" id="nom">
                    <small>Champ nom est obligatoire</small>
                </span>
                <span class="champ">
                    <label for="pwd">Password</label>
                    <input type="password" name="password" id="pwd" placeholder="********">
                    <small>Message d'erreur ici</small>
                </span>
                <span class="champ">
                    <input type="submit" value="Sign Up" id="btn">
                </span>
            </form>
            <div class="signUp">
                Already have account ? <a href="login.jsp">Log in</a>
            </div>
        </div>
    </div>
</body>
</html>