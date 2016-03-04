package com.storage;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Created by Nikita on 03.03.2016.
 */
class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular file: %s Content is %s%n ", file, Files.probeContentType(file));

        } else {
            System.out.format("Other: %s ", file);
        }
        System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }

    //Выводим информацию о посещенном каталоге
    @Override
/* Перечисление FileVisitResult имеет следующие варианты
CONTINUE продолжить проход.
SKIP_SIBLINGS продолжить проход без осмотра дочерних папок.
SKIP_SUBTREE продолжить без просмотра объектов данной папки.
TERMINATE заверщить.
*/
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.format("Directory: %s%n", dir);
        return CONTINUE;
    }
    //в случае ошибки доступа к файлу выбрасывается исключение IOException
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }
}
