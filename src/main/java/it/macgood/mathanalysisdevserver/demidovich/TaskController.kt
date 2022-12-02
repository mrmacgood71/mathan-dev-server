package it.macgood.mathanalysisdevserver.demidovich

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.nio.file.Files

@RestController
@RequestMapping("api/v1/demidovich")
class TaskController {
    val images: MutableList<Task> = mutableListOf()

    init {
        try {
            val file: File =
                File("src/main/resources/images/1.png")
            val file2: File =
                File("src/main/resources/images/2.png")
            val file3: File =
                File("src/main/resources/images/3.png")
            var buf: ByteArray = Files.readAllBytes(file.toPath())

            images.add(
                Task(
                    1L,
                    "1",
                    "Доказать, что если a и b – действительные числа",
                    buf
                )
            )
            buf = Files.readAllBytes(file2.toPath());
            images.add(
                Task(
                    2L,
                    "2",
                    "Доказать следующие равенства",
                    buf
                )
            )

            buf = Files.readAllBytes(file3.toPath());
            images.add(
                Task(
                    3L,
                    "3",
                    "Решить неравенства",
                    buf
                )
            )
        }catch (e: Exception) {
            println("error " + e.localizedMessage)

        }
    }

    @GetMapping
    fun findAll(): List<Task> {
        return images
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): Task {
        return images.find { task -> task.id.toString() == id }
            ?: Task(0L, "Error", "Error", byteArrayOf())
    }


}