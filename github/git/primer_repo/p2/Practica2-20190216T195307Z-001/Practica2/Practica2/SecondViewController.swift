//
//  SecondViewController.swift
//  Practica2
//
//  Created by Usuario invitado on 2/12/19.
//  Copyright © 2019 Usuario invitado. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    @IBOutlet weak var Entrada: UITextField!
    @IBOutlet weak var Prueba: UIButton!
    @IBOutlet weak var Salida: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .red
        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    @IBAction func Comprobar(_ sender: UIButton) {
        let vl = Entrada.stringValue
    }
    
}
