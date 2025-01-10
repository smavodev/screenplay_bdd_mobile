
@login
Feature: Login en la aplicacion mobile SauceLabs

  @login_exitoso
  Scenario: Inicio de session exitoso
    Given que el usuario esta en la app SwagLabs
    When el usuario ingrese sus credenciales usuario "standard_user" y password "secret_sauce"
    Then el incio de sesion es exitoso

  @login_usuario_bloqueado
  Scenario: Inicio de sesison fallido
    Given que el usuario esta en la app SwagLabs
    When el usuario ingrese sus credenciales usuario "locked_out_user" y password "secret_sauce"
    Then se muestra el mensaje "Sorry, this user has been locked out."