package com.company;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
        public static void main(String[]args) throws IOException, ParseException {
            String outputDoctores = "C:\\Users\\Lunka\\IdeaProjects\\EvidenciaComputacionJava-Master\\bd\\Doctores.csv";
            String outputPacientes = "C:\\Users\\Lunka\\IdeaProjects\\EvidenciaComputacionJava-Master\\bd\\Pacientes.csv";
            String outputCitas = "C:\\Users\\Lunka\\IdeaProjects\\EvidenciaComputacionJava-Master\\bd\\Citas.csv";

            BufferedWriter bwDoctores = new BufferedWriter(new FileWriter(outputDoctores, true));
            BufferedWriter bwPacientes = new BufferedWriter(new FileWriter(outputPacientes, true));
            BufferedWriter bwCitas = new BufferedWriter(new FileWriter(outputCitas, true));

            String line;
            Scanner in = new Scanner(System.in);

            System.out.print("¿Que acción deseas realizar? Estas son las opciones: \n Presiona D para dar de alta un doctor \n Presiona P para dar de alta un paciente \n Presiona C para agendar una cita\n");

            line = in.next();
            if (line.equals("D")) {
                System.out.print("Ingresa el nombre del doctor\n");
                String nombreDoctor = in.next();
                System.out.print("Ingresa la especialidad del doctor: \n");
                String especialidadDoctor = in.next();
                System.out.print("Ingresa el Id del doctor: \n");
                String idDoctor = in.next();
                Doctor doctorInfo = new Doctor(Integer.parseInt(idDoctor), nombreDoctor, especialidadDoctor);
                creaDoctor(doctorInfo, bwDoctores);
            } else if (line.equals("P")) {
                System.out.print("Ingresa el nombre del paciente\n");
                String nombrePaciente = in.next();
                System.out.print("Ingresa el id del paciente\n");
                String idPaciente = in.next();
                Pacientes pacienteInfo = new Pacientes(Integer.parseInt(idPaciente), nombrePaciente);
                creaPaciente(pacienteInfo, bwPacientes);

            } else if (line.equals("C")) {
                System.out.print("Ingresa la fecha de tu cita\n");
                String fechaCitaString = in.next();
                Date fechaCita = new SimpleDateFormat("dd/MM/yyyy").parse(fechaCitaString);
                System.out.print("Ingresa el motivo de tu cita\n");
                in.nextLine();
                String motivoCita = in.nextLine();
                System.out.print("Ingresa el id del doctor\n");
                String idDoctor = in.next();
                System.out.print("Ingresa el id del paciente\n");
                String idPaciente = in.next();
                Citas citaInfo = new Citas(fechaCita, Integer.parseInt(idDoctor), Integer.parseInt(idPaciente), motivoCita);
                creaCita(citaInfo, bwCitas);

            } else {
                System.out.print("selecciona una de las opciones disponibles");
            }


        }

    public static void creaDoctor(Doctor doctorInfo, BufferedWriter bw) throws IOException {
        bw.write(doctorInfo.id);
        bw.write(",");
        bw.write(doctorInfo.nombreDoctor);
        bw.write(",");
        bw.write(doctorInfo.esp);
        bw.write("\n");
        bw.close();

    }
    public static void creaPaciente(Pacientes pacienteInfo, BufferedWriter bw) throws IOException {
        bw.write(pacienteInfo.id);
        bw.write(",");
        bw.write(pacienteInfo.nombrePaciente);
        bw.write("\n");
        bw.close();

    }
    public static void creaCita(Citas citaInfo, BufferedWriter bw) throws IOException {
        bw.write(citaInfo.id);
        bw.write(",");
        bw.write(citaInfo.fechaCita.toString());
        bw.write(",");
        bw.write(citaInfo.motivoCita);
        bw.write(",");
        bw.write(citaInfo.idDoctor);
        bw.write(",");
        bw.write(citaInfo.idPaciente);
        bw.write("\n");
        bw.close();

    }
}
