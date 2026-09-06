import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// Servidor de desarrollo. El backend de Spring Boot
// corre en el puerto 8080 con CORS habilitado.
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
  },
})