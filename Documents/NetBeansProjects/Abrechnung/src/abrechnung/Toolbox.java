/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abrechnung;

import java.io.IOException;

/**
 *
 * @author MasnikJ
 */
public class Toolbox {
  
   public static void openOfficeFile() throws IOException{ 
   Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL C:\\Users\\MasnikJ\\Documents\\Abrechnung\\Serienbrief.docx");
   }
}


