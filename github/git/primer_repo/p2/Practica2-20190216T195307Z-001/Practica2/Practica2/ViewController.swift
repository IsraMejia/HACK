//
//  ViewController.swift
//  Practica2
//
//  Created by Usuario invitado on 2/12/19.
//  Copyright © 2019 Usuario invitado. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var Etiqueta: UILabel!
    @IBOutlet weak var Suma: UIButton!
    var counter:Int = 0
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
    }
    @IBAction func sumar(_ sender: UIButton) {
        if(counter<5){
            counter += 1
            Etiqueta.text = String(counter)
        }else{
            Etiqueta.text = "🥵"
        }
    }
    

}

