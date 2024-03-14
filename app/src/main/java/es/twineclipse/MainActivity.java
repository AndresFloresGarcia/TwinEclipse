package es.twineclipse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import es.twineclipse.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private List<Efecto> efectos;
    private ActivityMainBinding binding;
    private MediaPlayer mediaPlayer;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        inicializarEfectos();

        binding.button.setOnClickListener(v -> {
            Efecto efectoAleatorio = seleccionarEfectoAleatorio();

            binding.textViewEfecto.setText(efectoAleatorio.getTitulo());
            binding.textViewDescripcion.setText(efectoAleatorio.getDescripcion());
            binding.textViewTiempo.setText("Duración: " + efectoAleatorio.getDuracionHoras() + "h");

            establecerTipo(efectoAleatorio.getTipo(),view);

        });

        setContentView(view);
    }

    private void establecerTipo(TipoEfecto tipo, View view) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        switch (tipo) {
            case BUENO:
                view.setBackgroundColor(Color.GREEN);
                mediaPlayer = MediaPlayer.create(this, R.raw.bueno_sound);

                break;
            case NEUTRAL:
                view.setBackgroundColor(Color.GRAY);
                mediaPlayer = MediaPlayer.create(this, R.raw.neutral_sound);

                break;
            case MALO:
                view.setBackgroundColor(Color.RED);
                mediaPlayer = MediaPlayer.create(this, R.raw.malo_sound);
                break;
        }

        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(MediaPlayer::release);
        }
    }

    private Efecto seleccionarEfectoAleatorio() {
        Random random = new Random();
        return efectos.get(random.nextInt(efectos.size()));
    }

    private void inicializarEfectos() {
        efectos = new ArrayList<>();

        efectos.add(new Efecto("Niebla densa", "Visibilidad reducida", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Lluvia de patos de goma", "Divertido pero desconcertante", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Violencia animal", "Animales salvajes se vuelven agresivos", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Telepatía generalizada", "Todos pueden leer mentes", 48, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Crecimiento acelerado de plantas", "La flora crece a ritmo acelerado", 24, TipoEfecto.BUENO));
        efectos.add(new Efecto("Invisibilidad intermitente", "Los objetos y criaturas se vuelven invisibles por momentos", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Lluvia de gemas", "Gemas preciosas caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Locura colectiva", "Todos sufren de episodios de locura temporal", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Aparición de portales", "Portales a otros planos aparecen aleatoriamente", 48, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Enfriamiento repentino", "Temperaturas bajan drásticamente", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Magnetismo invertido", "Objetos son repelidos en lugar de atraídos", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Cambio de gravedad", "Gravedad se reduce a la mitad", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Aumento de habilidades físicas", "Fuerza y agilidad aumentan temporalmente", 24, TipoEfecto.BUENO));
        efectos.add(new Efecto("Poderes de curación aumentados", "Magia de curación es más efectiva", 24, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de objetos", "Objetos desaparecen y reaparecen en lugares aleatorios", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Alteración temporal", "El tiempo se distorsiona, causando lapsos aleatorios", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Lluvia de ácido", "Lluvia ácida daña estructuras y seres vivos", 6, TipoEfecto.MALO));
        efectos.add(new Efecto("Despertar de gigantes", "Antiguos gigantes vuelven a la vida", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Formas cambiantes", "Las formas de vida cambian temporalmente", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Polimorfismo masivo", "Todos se transforman en criaturas aleatorias", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Silencio absoluto", "Todo sonido es absorbido", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Tormenta de meteoritos", "Meteoritos caen del cielo", 6, TipoEfecto.MALO));
        efectos.add(new Efecto("Luz cegadora", "Luz intensa dificulta la visión", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Teletransportación aleatoria", "Todos son teletransportados a ubicaciones aleatorias", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Aumento de tamaño", "Todos crecen en tamaño", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Disminución de tamaño", "Todos reducen su tamaño", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Cambio de género", "Todos cambian temporalmente de género", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Sueños proféticos", "Todos tienen sueños premonitorios", 0, TipoEfecto.BUENO)); // Duración hasta el siguiente eclipse
        efectos.add(new Efecto("Inversión de colores", "Colores se invierten temporalmente", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Aparición de laberintos", "Laberintos aparecen en ciudades y bosques", 0, TipoEfecto.MALO)); // Duración hasta el siguiente eclipse
        efectos.add(new Efecto("Atracción magnética aumentada", "Objetos son irresistiblemente atraídos entre sí", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Despertar de entidades primordiales", "Seres primordiales emergen de la tierra", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Transferencia de almas", "Almas son transferidas aleatoriamente entre cuerpos", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Caída de estrellas fugaces", "Estrellas fugaces iluminan el cielo nocturno", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Aumento de inteligencia", "Inteligencia aumenta temporalmente", 24, TipoEfecto.BUENO));
        efectos.add(new Efecto("Amnesia colectiva", "Todos pierden la memoria temporalmente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de pétalos de flores", "Pétalos de flores caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Inundación repentina", "Inundaciones repentinas afectan las áreas bajas", 12, TipoEfecto.MALO));
        efectos.add(new Efecto("Cambio de gravedad", "Gravedad se invierte temporalmente", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Despertar de bestias antiguas", "Bestias ancestrales emergen de las profundidades", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Desaparición de magia", "Toda magia desaparece temporalmente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Noche perpetua", "El día se convierte en noche permanente", 0, TipoEfecto.MALO)); // Duración hasta el siguiente eclipse
        efectos.add(new Efecto("Despertar de la naturaleza", "La naturaleza cobra vida y se rebela contra los seres vivos", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Fusión de elementos", "Elementos se fusionan, creando fenómenos nuevos", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Ceguera temporal", "Todos pierden la vista temporalmente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de monedas", "Monedas de oro llueven del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Sismos constantes", "La tierra tiembla constantemente", 0, TipoEfecto.MALO)); // Duración hasta el siguiente eclipse
        efectos.add(new Efecto("Despertar de la oscuridad", "Sombras cobran vida y acechan a los desprevenidos", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de plumas", "Plumas caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Teleportación forzada", "Todos son teletransportados aleatoriamente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Descontrol de la magia", "Hechizos fallan o se vuelven impredecibles", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de piedras preciosas", "Piedras preciosas caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Tormenta eléctrica", "Relámpagos y truenos azotan la tierra", 12, TipoEfecto.MALO));
        efectos.add(new Efecto("Sueño profundo", "Todos caen en un sueño profundo", 0, TipoEfecto.NEUTRAL)); // Duración hasta el siguiente eclipse
        efectos.add(new Efecto("Iluminación divina", "Todos reciben visión divina temporalmente", 24, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de la gravedad", "Gravedad desaparece temporalmente", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Enjambre de insectos", "Insectos invaden el área", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Cambio climático repentino", "Clima cambia drásticamente", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Lluvia de joyas", "Joyas exóticas caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Fusión de mentes", "Mentes se fusionan temporalmente", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Despertar de titanes", "Titanes ancestrales despiertan de su sueño", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Desaparición de agua potable", "Fuentes de agua desaparecen temporalmente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Despertar de bestias legendarias", "Bestias legendarias resurgen", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de hojas doradas", "Hojas doradas caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desplazamiento temporal", "Eventos del pasado se repiten temporalmente", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Aumento de velocidad", "Todos se mueven a mayor velocidad", 24, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de la gravedad", "Gravedad desaparece completamente", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Despertar de los elementos primordiales", "Elementos primordiales se desatan", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de esporas mágicas", "Esporas mágicas caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Despertar de criaturas del abismo", "Criaturas del abismo emergen", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Distorsión temporal", "Tiempo se distorsiona, causando saltos en el tiempo", 24, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Lluvia de diamantes", "Diamantes caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de la realidad", "Realidad se desvanece temporalmente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Despertar de seres ancestrales", "Seres antiguos despiertan", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de piedras mágicas", "Piedras mágicas caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de la luz solar", "Luz solar desaparece temporalmente", 12, TipoEfecto.MALO));
        efectos.add(new Efecto("Despertar de los caídos", "Espíritus de los caídos regresan", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de hojas de plata", "Hojas de plata caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de la lógica", "La lógica se desvanece temporalmente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Despertar de los espíritus del bosque", "Espíritus del bosque se levantan", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de joyas de luna", "Joyas de luna caen del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de la gravedad", "Gravedad desaparece en áreas específicas", 12, TipoEfecto.NEUTRAL));
        efectos.add(new Efecto("Despertar de entidades cósmicas", "Seres cósmicos descienden al mundo", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Lluvia de polvo de estrellas", "Polvo de estrellas cae del cielo", 6, TipoEfecto.BUENO));
        efectos.add(new Efecto("Desaparición de la magia", "Toda magia desaparece temporalmente", 24, TipoEfecto.MALO));
        efectos.add(new Efecto("Despertar de los guardianes antiguos", "Guardianes ancestrales despiertan", 48, TipoEfecto.MALO));
        efectos.add(new Efecto("Desaparición de la gravedad", "Gravedad desaparece completamente", 24, TipoEfecto.NEUTRAL));
    }
}