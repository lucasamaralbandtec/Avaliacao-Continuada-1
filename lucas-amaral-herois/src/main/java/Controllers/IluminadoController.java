package Controllers;

import Interfaces.IHeroi;
import Interfaces.IVilao;
import com.heroes.lucasamaralherois.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/humanos")
public class IluminadoController
{
    private List<Humano> humanos = new ArrayList<>();

    //<Summary> Recupera todos os Humanos <\Summary>

    @GetMapping
    public ResponseEntity getTodos() {
        if (humanos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(humanos);
        }
    }

    //<Summary> Recupera entre todos os Humanos o da posição especificada <\Summary>

    @GetMapping("/{id}")
    public ResponseEntity getHumano(@PathVariable int id)
    {
        if (humanos.size() >= id) {
            humanos.get(id - 1);
            return ResponseEntity.status(200).build();
        } else
        {
            return ResponseEntity.status(404).build();
        }
    }

    //<Summary> Recupera todos aqueles que são Humanos Iluminados, indepedente se são heróis ou vilões <\Summary>

    @GetMapping("/iluminados")
    public ResponseEntity recuperarIluminados()
    {
        if (humanos.isEmpty())
        {
            return ResponseEntity.status(204).build();
        }
        else
        {
            List<Humano> batch = new ArrayList<>();
            for (Humano h : humanos)
            {
                if (h instanceof Iluminado)
                {
                    batch.add(h);
                }
            }
            return ResponseEntity.status(200).body(batch);
        }
    }

    //<Summary> Recupera todos aqueles que são somente Humanos, indepedente se são heróis ou vilões <\Summary>

    @GetMapping("/sempoderes")
    public ResponseEntity recuperarSemPoderes()
    {
        if (humanos.isEmpty())
        {
            return ResponseEntity.status(204).build();
        }
        else
        {
            List<Humano> batch = new ArrayList<>();
            for (Humano h : humanos)
            {
                if (!(h instanceof Iluminado))
                {
                    batch.add(h);
                }
            }
            return ResponseEntity.status(200).body(batch);
        }
    }

    //<Summary> Recupera todos aqueles que são heróis, independente de ter poder ou não <\Summary>

    @GetMapping("/herois")
    public ResponseEntity recuperarHerois()
    {
        if (humanos.isEmpty())
        {
            return ResponseEntity.status(204).build();
        }
        else
        {
            List<Humano> batch = new ArrayList<>();
            for (Humano h : humanos)
            {
                if (h instanceof IHeroi)
                {
                    batch.add(h);
                }
            }
            return ResponseEntity.status(200).body(batch);
        }
    }

    //<Summary> Recupera todos aqueles que são vilões, independente de ter poder ou não <\Summary>

    @GetMapping("/viloes")
    public ResponseEntity recuperarViloes()
    {
        if (humanos.isEmpty())
        {
            return ResponseEntity.status(204).build();
        }
        else
            {
                List<Humano> batch = new ArrayList<>();
            for (Humano h : humanos)
            {
                if (h instanceof IVilao)
                {
                    batch.add(h);
                }
            }
            return ResponseEntity.status(200).body(batch);
        }
    }

    //<Summary> Cria herois e vilões não iluminados <\Summary>

    @PostMapping("/novo/heroi")
    public ResponseEntity criarHeroi(@RequestBody Heroi heroi)
    {
        humanos.add(heroi);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/novo/vilao")
    public ResponseEntity criarHeroi(@RequestBody Vilao vilao)
    {
        humanos.add(vilao);
        return ResponseEntity.status(201).build();
    }

    //<Summary> Cria herois e vilões iluminados <\Summary>

    @PostMapping("/novoIluminado/heroi")
    public ResponseEntity criarHeroi(@RequestBody HeroiIluminado heroi)
    {
        humanos.add(heroi);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/novoIluminado/vilao")
    public ResponseEntity criarHeroi(@RequestBody VilaoIluminado vilao)
    {
        humanos.add(vilao);
        return ResponseEntity.status(201).build();
    }

    //<Summary> Exclui qualquer humano <\Summary>

    @DeleteMapping("/{id}")
    public ResponseEntity exluirHumano(@PathVariable int id)
    {
        if (humanos.size() >= id) {
            humanos.remove(id - 1);
            return ResponseEntity.status(200).build();
        } else
            {
            return ResponseEntity.status(404).build();
        }
    }
}