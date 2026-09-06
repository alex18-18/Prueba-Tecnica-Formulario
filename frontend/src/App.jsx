import { useEffect, useState } from 'react';

const API_URL = 'http://localhost:8080/api';

const STATE_INICIAL = {
  tipoIdentificacionId: '',
  numeroDocumento: '',
  nombres: '',
  apellidos: '',
  fechaNacimiento: '',
  direccion: '',
  paisId: '',
  departamentoId: '',
  ciudadId: '',
  marcaId: '',
};

function App() {
  const [tiposIdentificacion, setTiposIdentificacion] = useState([]);
  const [paises, setPaises] = useState([]);
  const [departamentos, setDepartamentos] = useState([]);
  const [ciudades, setCiudades] = useState([]);
  const [marcas, setMarcas] = useState([]);

  const [formulario, setFormulario] = useState(STATE_INICIAL);
  const [mensaje, setMensaje] = useState('');
  const [esError, setEsError] = useState(false);
  const [enviando, setEnviando] = useState(false);

  // Se cargan los catálogos una sola vez al montar el componente
  useEffect(() => {
    cargarTiposIdentificacion();
    cargarPaises();
    cargarMarcas();
  }, []);

  const cargarTiposIdentificacion = async () => {
    try {
      const respuesta = await fetch(`${API_URL}/tipos-identificacion`);
      setTiposIdentificacion(await respuesta.json());
    } catch (error) {
      console.error('Error al cargar tipos de identificación:', error);
    }
  };

  const cargarPaises = async () => {
    try {
      const respuesta = await fetch(`${API_URL}/paises`);
      setPaises(await respuesta.json());
    } catch (error) {
      console.error('Error al cargar países:', error);
    }
  };

  const cargarMarcas = async () => {
    try {
      const respuesta = await fetch(`${API_URL}/marcas`);
      setMarcas(await respuesta.json());
    } catch (error) {
      console.error('Error al cargar marcas:', error);
    }
  };

  const cargarDepartamentos = async (paisId) => {
    setDepartamentos([]);
    setCiudades([]);
    if (!paisId) return;
    try {
      const respuesta = await fetch(`${API_URL}/departamentos/${paisId}`);
      setDepartamentos(await respuesta.json());
    } catch (error) {
      console.error('Error al cargar departamentos:', error);
    }
  };

  const cargarCiudades = async (departamentoId) => {
    setCiudades([]);
    if (!departamentoId) return;
    try {
      const respuesta = await fetch(`${API_URL}/ciudades/${departamentoId}`);
      setCiudades(await respuesta.json());
    } catch (error) {
      console.error('Error al cargar ciudades:', error);
    }
  };

  const manejarCambio = (evento) => {
    const { name, value } = evento.target;

    // País y departamento llenan los selects en cascada
    if (name === 'paisId') {
      setFormulario((estado) => ({ ...estado, paisId: value, departamentoId: '', ciudadId: '' }));
      cargarDepartamentos(value);
      return;
    }

    if (name === 'departamentoId') {
      setFormulario((estado) => ({ ...estado, departamentoId: value, ciudadId: '' }));
      cargarCiudades(value);
      return;
    }

    setFormulario((estado) => ({ ...estado, [name]: value }));
  };

  const enviarFormulario = async (evento) => {
    evento.preventDefault();
    setEnviando(true);
    setMensaje('');

    // Los campos de listas llegan como cadena en el formulario,
    // así que se convierten a número para el backend.
    const cuerpo = {
      ...formulario,
      tipoIdentificacionId: Number(formulario.tipoIdentificacionId),
      paisId: Number(formulario.paisId),
      departamentoId: Number(formulario.departamentoId),
      ciudadId: Number(formulario.ciudadId),
      marcaId: Number(formulario.marcaId),
    };

    try {
      const respuesta = await fetch(`${API_URL}/clientes`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(cuerpo),
      });

      if (!respuesta.ok) {
        throw new Error('El servidor respondió con un error');
      }

      setEsError(false);
      setMensaje('¡El cliente fue registrado exitosamente!');
      setFormulario(STATE_INICIAL);
      setDepartamentos([]);
      setCiudades([]);
    } catch (error) {
      console.error('Error al guardar el cliente:', error);
      setEsError(true);
      setMensaje('Ocurrió un error al guardar el cliente. Inténtelo de nuevo.');
    } finally {
      setEnviando(false);
    }
  };

  return (
    <div className="contenedor">
      <header className="encabezado">
        <h1>Fidelización de Clientes</h1>
        <p>Complete el formulario para registrar a un nuevo cliente.</p>
      </header>

      {mensaje && (
        <div className={esError ? 'alerta alerta-error' : 'alerta alerta-exito'}>{mensaje}</div>
      )}

      <form className="formulario" onSubmit={enviarFormulario}>
        <fieldset>
          <legend>Datos de identificación</legend>
          <div className="fila">
            <label htmlFor="tipoIdentificacionId">Tipo de documento</label>
            <select
              id="tipoIdentificacionId"
              name="tipoIdentificacionId"
              value={formulario.tipoIdentificacionId}
              onChange={manejarCambio}
              required
            >
              <option value="" disabled>
                -- Seleccione --
              </option>
              {tiposIdentificacion.map((tipo) => (
                <option key={tipo.id} value={tipo.id}>
                  {tipo.nombre}
                </option>
              ))}
            </select>
          </div>

          <div className="fila">
            <label htmlFor="numeroDocumento">Número de documento</label>
            <input
              id="numeroDocumento"
              name="numeroDocumento"
              type="text"
              value={formulario.numeroDocumento}
              onChange={manejarCambio}
              placeholder="Ej: 123456789"
              required
            />
          </div>

          <div className="fila">
            <label htmlFor="nombres">Nombres</label>
            <input
              id="nombres"
              name="nombres"
              type="text"
              value={formulario.nombres}
              onChange={manejarCambio}
              placeholder="Ej: Juan Carlos"
              required
            />
          </div>

          <div className="fila">
            <label htmlFor="apellidos">Apellidos</label>
            <input
              id="apellidos"
              name="apellidos"
              type="text"
              value={formulario.apellidos}
              onChange={manejarCambio}
              placeholder="Ej: Pérez Gómez"
              required
            />
          </div>

          <div className="fila">
            <label htmlFor="fechaNacimiento">Fecha de nacimiento</label>
            <input
              id="fechaNacimiento"
              name="fechaNacimiento"
              type="date"
              value={formulario.fechaNacimiento}
              onChange={manejarCambio}
              required
            />
          </div>
        </fieldset>

        <fieldset>
          <legend>Ubicación</legend>
          <div className="fila">
            <label htmlFor="direccion">Dirección</label>
            <input
              id="direccion"
              name="direccion"
              type="text"
              value={formulario.direccion}
              onChange={manejarCambio}
              placeholder="Ej: Calle 10 # 20 - 30"
              required
            />
          </div>

          <div className="fila">
            <label htmlFor="paisId">País</label>
            <select
              id="paisId"
              name="paisId"
              value={formulario.paisId}
              onChange={manejarCambio}
              required
            >
              <option value="" disabled>
                -- Seleccione --
              </option>
              {paises.map((pais) => (
                <option key={pais.id} value={pais.id}>
                  {pais.nombre}
                </option>
              ))}
            </select>
          </div>

          <div className="fila">
            <label htmlFor="departamentoId">Departamento</label>
            <select
              id="departamentoId"
              name="departamentoId"
              value={formulario.departamentoId}
              onChange={manejarCambio}
              disabled={!formulario.paisId}
              required
            >
              <option value="" disabled>
                {formulario.paisId ? '-- Seleccione --' : 'Primero seleccione un país'}
              </option>
              {departamentos.map((departamento) => (
                <option key={departamento.id} value={departamento.id}>
                  {departamento.nombre}
                </option>
              ))}
            </select>
          </div>

          <div className="fila">
            <label htmlFor="ciudadId">Ciudad</label>
            <select
              id="ciudadId"
              name="ciudadId"
              value={formulario.ciudadId}
              onChange={manejarCambio}
              disabled={!formulario.departamentoId}
              required
            >
              <option value="" disabled>
                {formulario.departamentoId ? '-- Seleccione --' : 'Primero seleccione un departamento'}
              </option>
              {ciudades.map((ciudad) => (
                <option key={ciudad.id} value={ciudad.id}>
                  {ciudad.nombre}
                </option>
              ))}
            </select>
          </div>
        </fieldset>

        <fieldset>
          <legend>Marca preferida</legend>
          <div className="fila">
            <label htmlFor="marcaId">Marca</label>
            <select id="marcaId" name="marcaId" value={formulario.marcaId} onChange={manejarCambio} required>
              <option value="" disabled>
                -- Seleccione --
              </option>
              {marcas.map((marca) => (
                <option key={marca.id} value={marca.id}>
                  {marca.nombre}
                </option>
              ))}
            </select>
          </div>
        </fieldset>

        <div className="acciones">
          <button type="submit" disabled={enviando}>
            {enviando ? 'Guardando...' : 'Registrar cliente'}
          </button>
        </div>
      </form>
    </div>
  );
}

export default App;