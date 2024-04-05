package com.company;

import java.io.IOException;

public abstract class Command {
    
    public abstract void execute(String ... parameters) throws IOException, InvalidCommandException;
}